function popUp(url){
	var newwindow;
	newwindow = window.open(url, 'name', 'height=1000, width=800');
	if (window.focus) {
		newwindow.focus()
	}
		
}