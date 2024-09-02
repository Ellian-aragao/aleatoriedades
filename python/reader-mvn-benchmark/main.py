import os
import re
import sqlite3

path = '/home/ellian/code/faculdade/IFB-AA/2024/projeto2-analise-algoritmo-sqrsort/docs'

regex_first_line_benchmark_data = f'Benchmark.* Mode.* Cnt.* Score.* Error.* Units'
regex_last_line_benchmark_data = f'AlgoritmoRunner.* avgt.*'


def read_benchmark_data(filepath=''):
    with open(filepath, 'r') as log_file:
        result_benchmark_str = []

        pattern = re.compile(regex_last_line_benchmark_data)
        for lines in log_file:
            if pattern.search(lines):
                result_benchmark_str.append(lines.split())

        algorithm_dict = {
            'B': 'bubble',
            'H': 'heap'
        }

        benchmark_data = []

        for lines in result_benchmark_str:
            input_lenght = int(re.split(r'(s)', lines[0].split('.')[1])[-1])
            input_and_algorithm = re.split(r'([A-Z])', lines[0].split('_')[-1])
            input_type = input_and_algorithm[0]
            algorithm_name = algorithm_dict[input_and_algorithm[1]]
            score = lines[3]
            error = lines[5]

            benchmark_data.append({
                'input_lenght': input_lenght,
                'input_type': input_type,
                'algorithm': algorithm_name,
                'score': score,
                'error': error,
            })

        return benchmark_data


def get_all_info_from_benchmark_files():
    files = os.listdir(path)
    benchmark_data = []
    for file in files:
        [benchmark_data.append(info) for info in read_benchmark_data(f'{path}/{file}')]
    return benchmark_data


def insert_data_to_sqlite():
    lines_to_insert = []
    for info in data:
        tuple_insert = (info.get('input_lenght'),
                        info.get('input_type'),
                        info.get('algorithm'),
                        info.get('score'),
                        info.get('error'))

        lines_to_insert.append(tuple_insert)

    cursor.executemany("""
    INSERT INTO benchmark_data (input_lenght, input_type, algorithm, score, error)
        VALUES(?, ?, ?, ?, ?);
    """, lines_to_insert)
    con.commit()


def run_migrations():
    scripts = os.listdir('./scripts')
    for script in scripts:
        with open(f'./scripts/{script}') as file:
            cursor.executescript(file.read())


if __name__ == '__main__':
    con = sqlite3.connect('algorithm_data.db')
    cursor = con.cursor()

    run_migrations()

    data = get_all_info_from_benchmark_files()

    insert_data_to_sqlite()
