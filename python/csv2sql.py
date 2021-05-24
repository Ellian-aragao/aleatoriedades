import sys
import csv


def main(args):
    with open(args[1]) as csvfile:
        reader = csv.reader(csvfile, delimiter=',')
#        print('INSERT INTO tb_idioma (id_idioma, ds_abreviacao, ds_descricao) VALUES')
        for i, line in enumerate(reader):
            print('({},'.format(i + 1), end='')
            print('\'{}\''.format(line[0]), end='')
            print('),')


if __name__ == '__main__':
    sys.exit(main(sys.argv))
