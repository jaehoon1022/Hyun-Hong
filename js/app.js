const search = document.querySelector('#main_Search')
const searchBtn = document.querySelector('header button')

function searchClick(){
  if (search.value.trim() != ""){
  
    console.log(search.value.trim())
    // location.href = `find?id=${search.value.trim()}`
    location.href = `statistics.html`
    document.id.submit();
  }
}
searchBtn.addEventListener('click',searchClick)