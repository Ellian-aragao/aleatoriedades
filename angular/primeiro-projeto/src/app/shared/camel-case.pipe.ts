import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'camelCase'
})
export class CamelCasePipe implements PipeTransform {

  transform(value: string): string {
    let result = '';
    value.split(' ')
      .forEach(palavras => {
        result += this.capitalize(palavras) + ' ';
      });
    return result;
  }

  capitalize(str: string): string {
    return str.substr(0, 1).toUpperCase() + str.substr(1);
  }
}
