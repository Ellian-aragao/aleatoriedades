class NegociacoesView extends View {

    constructor(elemento) {
        super(elemento)
    }

    update(listaDeNegociacao) {
        this._elemento.innerHTML = this.template(listaDeNegociacao)
    }

    template(listaDeNegociacao) {
        return `
        <table class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th>DATA</th>
                    <th>QUANTIDADE</th>
                    <th>VALOR</th>
                    <th>VOLUME</th>
                </tr>
            </thead>
        
            <tbody class="conteudo-tabela">
                ${listaDeNegociacao.negociacoes.map(negociacao => this._criaTr(negociacao)).join('')}
            </tbody>

            <tfoot>
                <td colspan="3"></td>
                <td>${listaDeNegociacao.negociacoes.reduce((total,negociacao) => total += negociacao.volume, 0)}</td>
            </tfoot>

        </table>
            `
    }

    _criaTr(negociacao) {
        return (`
            <tr class="negociacao">
                ${this._criaTd("info-data" ,DateHelper.dateToString(negociacao.data))}
                ${this._criaTd("info-quantidade" ,negociacao.quantidade)}
                ${this._criaTd("info-valor" ,negociacao.valor)}
                ${this._criaTd("info-volume" ,negociacao.volume)}
            </tr>
            `
        )
    }

    _criaTd(className, value) {
        return `<td class="${className}">${value}</td>`
    }
}
