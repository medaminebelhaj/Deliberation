(function($) {



    var form = $("#signup-form");
    form.validate({
        errorPlacement: function errorPlacement(error, element) {
            element.before(error);
        },
        rules: {
            email: {
                email: true
            }
        },
        onfocusout: function(element) {
            $(element).valid();
        },
    });
    form.children("div").steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "fade",
        stepsOrientation: "vertical",
        titleTemplate: '<div class="title"><span class="step-number">#index#</span><span class="step-text">#title#</span></div>',
        labels: {
            previous: 'Previous',
            next: 'Next',
            finish: 'Finish',
            current: ''
        },
        onStepChanging: function(event, currentIndex, newIndex) {
        	
        	
            if (currentIndex === 0) {
                form.parent().parent().parent().append('<div class="footer footer-' + currentIndex + '"></div>');
               
                
               // form.submit();
                
                $.ajax({
                    type: form.attr('method'),
                    url: form.attr('action'),
                    data: form.serialize(),
                    dataType : 'json',
                    success: function (data) {
                    	
                       var string1 = JSON.stringify(data);
       		        var parsed = JSON.parse(string1);  
       		       
       		        for (var i = 0; i < parsed.length; i++) {
       		        var newStr = parsed[i].replace('[', '');
       		        newStr=newStr.replace(']','');
       		       
       		     
       		        var myArray = newStr.split(",");
       		       // alert(myArray[0]);
       		       // alert(myArray[1]);
       		       // var option = document.createElement("option");
       		       
       		        //option.text = myArray[1];
       		        //option.value=myArray[0];
       		       // x.add(option);
       		     var checkbox = document.createElement("input");
       		    
       		   checkbox.type = 'checkbox';
       	       checkbox.id = 'car';
       	       checkbox.name = 'listmodulechekbox';
       	       checkbox.value = myArray[1];
       		     
       		        
       		   var label = document.createElement('label')
       	    label.htmlFor = myArray[0];
       	    label.appendChild(document.createTextNode(myArray[0]));
       	 
       	    var br = document.createElement('br');
       	 
       	    var container = document.getElementById('listmodulechekbox');
       	    container.appendChild(checkbox);
       	    container.appendChild(label);
       	    container.appendChild(br);
       		       
       		        }
                       
                    },
                    error: function (data) {
                        console.log('An error occurred.');
                        console.log(data);
                    },
                });
                
             //   var form = document.getElementById("form-id");
                
                
                
                
                
            }
            if (currentIndex === 1) {
            	
            	alert('je suis la ');
                form.parent().parent().parent().find('.footer').removeClass('footer-0').addClass('footer-' + currentIndex + '');
                
                $.ajax({
                    type: 'POST',
                    url: 'listElement',
                    data: form.serialize(),
                    dataType : 'json',
                    success: function (data) {
                    	
                    alert(data);
                     
                      var string1 = JSON.stringify(data);
       		        var parsed = JSON.parse(string1);  
       		       
       		        for (var i = 0; i < parsed.length; i++) {
       		        var newStr = parsed[i].replace('[', '');
       		        newStr=newStr.replace(']','');
       		       
       		     
       		        var myArray = newStr.split(",");
       		       // alert(myArray[0]);
       		       // alert(myArray[1]);
       		       // var option = document.createElement("option");
       		       
       		        //option.text = myArray[1];
       		        //option.value=myArray[0];
       		       // x.add(option);
       		     var checkbox = document.createElement("input");
       		   checkbox.type = 'checkbox';
       	       checkbox.id = 'car';
       	       checkbox.name = 'listelementchekbox';
       	       checkbox.value = myArray[1]+','+myArray[2];
       		     
       		        
       		 var label = document.createElement('label')
       	    label.htmlFor = myArray[1];
       	    label.appendChild(document.createTextNode(myArray[0]));
       	    alert(myArray[0]);
       	    var br = document.createElement('br');
       	 
       	    var container = document.getElementById('listelementchekbox');
       	  container.appendChild(label);
       	    container.appendChild(checkbox);
       	  
       	    container.appendChild(br);
       		       
       		        }
                       
                    },
                    error: function (data) {
                        console.log('An error occurred.');
                        console.log(data);
                    },
                });
                
            }
            if (currentIndex === 2) {
            	
              
            	
            	
                form.parent().parent().parent().find('.footer').removeClass('footer-1').addClass('footer-' + currentIndex + '');
            }
            if (currentIndex === 3) {
            
            	
                form.parent().parent().parent().find('.footer').removeClass('footer-2').addClass('footer-' + currentIndex + '');
            }
            // if(currentIndex === 4) {
            //     form.parent().parent().parent().append('<div class="footer" style="height:752px;"></div>');
            // }
            form.validate().settings.ignore = ":disabled,:hidden";
            return form.valid();
        },
        onFinishing: function(event, currentIndex) {
            form.validate().settings.ignore = ":disabled";
            return form.valid();
        },
        onFinished: function(event, currentIndex) {
            alert('Submited form succed');
            
            
            $.ajax({
                type: 'POST',
                url: 'InscriptionPeda2',
                data: form.serialize(),
                dataType : 'json',
                success: function (data) {
                	
                	alert(data);
                 
          
                   
                },
                error: function (data) {
                    console.log('An error occurred.');
                    console.log(data);
                },
            });
        },
        onStepChanged: function(event, currentIndex, priorIndex) {

            return true;
        }
    });

    jQuery.extend(jQuery.validator.messages, {
        required: "",
        remote: "",
        email: "",
        url: "",
        date: "",
        dateISO: "",
        number: "",
        digits: "",
        creditcard: "",
        equalTo: ""
    });

    $.dobPicker({
        daySelector: '#birth_date',
        monthSelector: '#birth_month',
        yearSelector: '#birth_year',
        dayDefault: '',
        monthDefault: '',
        yearDefault: '',
        minimumAge: 0,
        maximumAge: 120
    });
    var marginSlider = document.getElementById('slider-margin');
    if (marginSlider != undefined) {
        noUiSlider.create(marginSlider, {
              start: [1100],
              step: 100,
              connect: [true, false],
              tooltips: [true],
              range: {
                  'min': 100,
                  'max': 2000
              },
              pips: {
                    mode: 'values',
                    values: [100, 2000],
                    density: 4
                    },
                format: wNumb({
                    decimals: 0,
                    thousand: '',
                    prefix: '$ ',
                })
        });
        var marginMin = document.getElementById('value-lower'),
	    marginMax = document.getElementById('value-upper');

        marginSlider.noUiSlider.on('update', function ( values, handle ) {
            if ( handle ) {
                marginMax.innerHTML = values[handle];
            } else {
                marginMin.innerHTML = values[handle];
            }
        });
    }
})(jQuery);