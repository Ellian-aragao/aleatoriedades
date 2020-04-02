document.querySelector("#adicionar-paciente").addEventListener("click", function(event) {
    event.preventDefault()
    var dadosDoFormulario = document.querySelector("#formularioDeAdicao")
    var linhaDoPaciente = criaTrDoPaciente(criaPacienteDoFormulario(dadosDoFormulario))
    document.querySelector("#tabela-pacientes").appendChild(linhaDoPaciente)
    dadosDoFormulario.reset()
})

function criaPacienteDoFormulario(form) {
    var paciente = {
        nome:    form.nome.value,
        peso:    form.peso.value,
        altura:  form.altura.value,
        gordura: form.gordura.value,
        imc:     calcImc(form.peso.value, form.altura.value)
    }
    return paciente
}

function criaTd(classhtml, value) {
    var coluna = document.createElement("td")
    coluna.classList.add(classhtml)
    coluna.textContent = value
    return coluna
}

function criaTrDoPaciente(paciente) {
    var linha = document.createElement("tr")
    linha.appendChild(criaTd("info-nome", paciente.nome))
    linha.appendChild(criaTd("info-peso", paciente.peso))
    linha.appendChild(criaTd("info-altura", paciente.altura))
    linha.appendChild(criaTd("info-gordura", paciente.gordura))
    linha.appendChild(criaTd("info-imc", paciente.imc))
    return linha
}
