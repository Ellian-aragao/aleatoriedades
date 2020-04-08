class NegociacaoController {

    constructor() {
        let $ = document.querySelector.bind(document)
        let formulario = $(".form")

        this._formData = formulario.data
        this._formQuantidade = formulario.quantidade
        this._formValor = formulario.valor


        this._mensagem = new Mensagem()
        // this._listaNegociacoes = new ListaNegociacao()

        let self = this
        this._listaNegociacoes = new Proxy(new ListaNegociacao(), {
            get(target, prop, receiver) {
                if(['adiciona', 'esvazia'].includes(prop) && typeof(target[prop]) == typeof(Function)) {
                    return function(){
                        console.log(`método '${prop}' interceptado`);

                        Reflect.apply(target[prop], target, arguments);

                        self._negociacaoView.update(target);
                    }
                }
                return Reflect.get(target, prop, receiver);
                /*
                O target é o objeto real que é encapsulado pela proxy.
                O prop é a propriedade em si, que está sendo lida naquele momento.
                O receiver é a referência ao próprio proxy.
                */
            }
        });
        
        this._negociacaoView = new NegociacoesView($("#negociacoesView"))
        this._mensagemView = new MensagemView($('#mensagemView'))
        
        this._negociacaoView.update(this._listaNegociacoes)
        this._mensagemView.update(this._mensagem)
    }

    apaga(event) {
        event.preventDefault()

        this._listaNegociacoes.esvazia()
        this._mensagem.texto = 'Negociações apagadas com sucesso'
        
        // this._negociacaoView.update(this._listaNegociacoes)
        this._mensagemView.update(this._mensagem)
    }
    
    adiciona(event) {
        event.preventDefault()

        this._listaNegociacoes.adiciona(this._criaNegociacao())
        this._mensagem.texto = 'Negociação adicionada com sucesso'
        
        // this._negociacaoView.update(this._listaNegociacoes)
        this._mensagemView.update(this._mensagem)

        this._limpaFormulario()
    }

    _criaNegociacao() {
        return (new Negociacao(
            new Date(DateHelper.stringToDate(this._formData.value)),
            this._formQuantidade.value,
            this._formValor.value
        ))
    }

    _limpaFormulario() {
        this._formData.value = ''
        this._formQuantidade.value = 1
        this._formValor.value = 0.0
        this._formData.focus()
    }
}
