(async () => {
  const nose = await axios.get("http://localhost:4567/hello");
  console.log(JSON.stringify(nose));
  console.log(nose.data.pyramid[0].pyramid);

  let count = Object.keys(nose.data.pyramid).length;
  console.log(count);

  // const cars = document.querySelector(".pyramid");
  let newList = "<ul>";
  for (let index = 0; index < count; index++) {
    newList += `<li><a href="detail.html?q=${nose.data.pyramid[index].id}">Pyramid n° ${nose.data.pyramid[index].id}</a></li>`;
    console.log(newList);
  }
  newList += "</ul>";
  pyramid.innerHTML = newList;
  return nose;
})();
