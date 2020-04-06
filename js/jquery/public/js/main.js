function contadorPalavras(txt) {
    return txt.split(/\s+/).length - 1
}

var tamFrase = contadorPalavras($(".frase").text())
$(".numero-de-palavras").text(tamFrase + " palavras")

var campo = $(".campo-digitacao")
campo.on("input", function() {
    var str = campo.val()
    $(".contador-caracteres").text(str.length + " caracteres digitados")
    $(".contador-palavras").text(contadorPalavras(str) + " palavras digitadas")
});