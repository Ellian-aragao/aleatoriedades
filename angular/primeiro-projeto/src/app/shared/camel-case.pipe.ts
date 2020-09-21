import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'camelCase'
})
export class CamelCasePipe implements PipeTransform {

  transform(value: string): string {
    const values = value.split(' ');
    let result = '';
    values.forEach((palavra: string) => {
      result += this.capitalize(palavra);
    });
    return result;
  }

  capitalize(str: string): string {
    return str.substr(0, 1).toUpperCase() + str.substr(1);
  }
}
