
	const myFunction = () => {
		  const trs = document.querySelectorAll('#myTable tr:not(.header)')
		  const filter = document.querySelector('#myInput').value
		  const regex = new RegExp(filter, 'i')
		  const isFoundInTds = td => regex.test(td.innerHTML)
		  const isFound = childrenArr => childrenArr.some(isFoundInTds)
		  const setTrStyleDisplay = ({ style, children }) => {
		    style.display = isFound([
		      ...children // <-- All columns
		    ]) ? '' : 'none' 
		  }
		  
		  trs.forEach(setTrStyleDisplay)
		}
