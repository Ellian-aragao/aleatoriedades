document.querySelector("#buscar-paciente").addEventListener("click", event => {
    var xhr = new XMLHttpRequest()

    xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes")
    xhr.addEventListener("load", function() {
        pacientes = JSON.parse(xhr.responseText)
        pacientes.forEach(paciente => {
            addPacienteNaTabela(paciente,criaPacienteDoJSON)
        });
    })
    xhr.send()
})

function criaPacienteDoJSON(paciente) {
    var pacienteObject = {
        nome:    paciente.nome,
        peso:    paciente.peso,
        altura:  paciente.altura,
        gordura: paciente.gordura,
        imc:     calcImc(paciente.peso, paciente.altura)
    }
    return pacienteObject
}
