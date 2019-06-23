const cities = document.querySelector('#cities');
const city_cont =  document.querySelector('#city-cont')

if(cities) {
	//* Set as default value the first option element
	let city = cities.value;
	city_cont.innerHTML = city;
	
	//* Sets the selected city
	cities.addEventListener('change', (e) => {
		city = e.target.value;
		city_cont.innerHTML = city;
	});
	
}