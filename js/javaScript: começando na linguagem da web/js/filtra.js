tabela = document.querySelector("#filtrar-tabela")
tabela.addEventListener("input",function() {
    var nomePesquisado = new RegExp(this.value,"i")
    var pacientes = document.querySelectorAll(".paciente")

    pacientes.forEach(paciente => {
        var nomePaciente = paciente.querySelector(".info-nome").textContent
        if(nomePesquisado.test(nomePaciente)) {
            paciente.classList.remove("invisivel")
        } else {
            paciente.classList.add("invisivel")
        }
    });
})
