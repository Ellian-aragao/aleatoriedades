import { Component } from '@angular/core';
import { ConsultaCepService } from 'src/app/services/consulta-cep.service.service';

@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
})
export class TemplateFormComponent {

  usuario: any = {
    nome: null,
    email: null
  };

  constructor(private cepService: ConsultaCepService) { }

  onSubmit(formulario: any): void {
    console.log(formulario);

    // this.http.post('https://httpbin.org/post', JSON.stringify(formulario.value))
    //   .subscribe(dados => {
    //     console.log(dados);
    //     formulario.form.reset();
    //   });
  }

  verificaValidTouched(campo: { valid: any; touched: any; }): boolean {
    return !campo.valid && campo.touched;
  }

  aplicaCssErro(campo: any): any {
    return {
      'has-error': this.verificaValidTouched(campo),
      'has-feedback': this.verificaValidTouched(campo)
    };
  }

  consultaCEP(cep: string, form: any): void {
    cep = cep.replace(/\D/g, '');
    if (cep != null && cep !== '') {
      this.cepService.consultaCEP(cep)
        .subscribe(dados => this.populaDadosForm(dados, form));
    }
  }

  populaDadosForm(dados: any, formulario: {
    form: {
      patchValue: (arg0: {
        endereco: {
          rua: any;
          // cep: dados.cep,
          complemento: any; bairro: any; cidade: any; estado: any;
        };
      }) => void;
    };
  }): void {
    /*formulario.setValue({
      nome: formulario.value.nome,
      email: formulario.value.email,
      endereco: {
        rua: dados.logradouro,
        cep: dados.cep,
        numero: '',
        complemento: dados.complemento,
        bairro: dados.bairro,
        cidade: dados.localidade,
        estado: dados.uf
      }
    });*/

    formulario.form.patchValue({
      endereco: {
        rua: dados.logradouro,
        // cep: dados.cep,
        complemento: dados.complemento,
        bairro: dados.bairro,
        cidade: dados.localidade,
        estado: dados.uf
      }
    });

  }

  resetaDadosForm(formulario: {
    form: {
      patchValue: (arg0: {
        endereco: {
          rua: any;
          complemento: any;
          bairro: any;
          cidade: any;
          estado: any;
        };
      }) => void;
    };
  }): void {
    formulario.form.patchValue({
      endereco: {
        rua: null,
        complemento: null,
        bairro: null,
        cidade: null,
        estado: null
      }
    });
  }
}
