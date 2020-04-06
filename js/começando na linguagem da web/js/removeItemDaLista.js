document.querySelector("#tabela-pacientes").addEventListener("dblclick", table => {
    table.target.parentNode.classList.add("fadeOut")
    setTimeout(() => {
        table.target.parentNode.remove()
    }, 500)
})
