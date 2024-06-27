function addInput(id){
    const element = document.getElementById(id);
    const index = element.children.length;
    const input = document.createElement("input");

    console.log(index);
    input.type = "text";
    input.className = 'form-control mb-2';
    if(id === "ingredients"){
        input.name = `ingredients[${index}]`;
        input.placeholder = "Ingredient"
    }
    else if(id === "steps"){
        input.name = `steps[${index}]`;
        input.placeholder = "Steps"
    }

    element.appendChild(input);
}