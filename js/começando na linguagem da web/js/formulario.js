document.querySelector("#adicionar-paciente").addEventListener("click", function(event) {
    event.preventDefault()
    var dadosDoFormulario = document.querySelector("#formularioDeAdicao")
    addPacienteNaTabela(dadosDoFormulario, criaPacienteDoFormulario)
    dadosDoFormulario.reset()
})

function addPacienteNaTabela(paciente, funcaoEstruturaPaciente) {
    var linhaDoPaciente = criaTrDoPaciente(funcaoEstruturaPaciente(paciente))
    document.querySelector("#tabela-pacientes").appendChild(linhaDoPaciente)
}

function criaPacienteDoFormulario(paciente) {
    var pacienteObject = {
        nome:    paciente.nome.value,
        peso:    paciente.peso.value,
        altura:  paciente.altura.value,
        gordura: paciente.gordura.value,
        imc:     calcImc(paciente.peso.value, paciente.altura.value)
    }
    return pacienteObject
}

function criaTrDoPaciente(paciente) {
    var linha = document.createElement("tr")
    linha.classList.add("paciente")
    linha.appendChild(criaTd("info-nome", paciente.nome))
    linha.appendChild(criaTd("info-peso", paciente.peso))
    linha.appendChild(criaTd("info-altura", paciente.altura))
    linha.appendChild(criaTd("info-gordura", paciente.gordura))
    linha.appendChild(criaTd("info-imc", paciente.imc))
    return linha
}

function criaTd(classhtml, value) {
    var coluna = document.createElement("td")
    coluna.classList.add(classhtml)
    coluna.textContent = value
    return coluna
}
