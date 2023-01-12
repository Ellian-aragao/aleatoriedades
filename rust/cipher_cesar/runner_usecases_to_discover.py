import subprocess


def execute(iteration: int, string_to_parse: str) -> None:
    data = f'./target/release/cipher_cesar {iteration} "{string_to_parse}"'
    subprocessData = subprocess.run(
        data,
        shell=True,
        stdout=subprocess.PIPE,
    )
    print(subprocessData.stdout.decode("utf-8"))


if __name__ == "__main__":
    data = "dznzcclx-xp, dfmt yz zytmfd px xlccznzd"
    for i in range(1, 26):
        execute(i, data)
