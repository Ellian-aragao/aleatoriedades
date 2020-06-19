import os


def exploreFiles(absolute_path):
    arrayDirOrFiles = os.listdir(absolute_path)
    for oneFileOrDir in arrayDirOrFiles:
        fullPath = '{}/{}'.format(absolute_path, oneFileOrDir)
        if os.path.isdir(fullPath):
            print('dir -> {}'.format(oneFileOrDir))
            exploreFiles(fullPath)
        else:
            print('file -> {}'.format(oneFileOrDir))


varPath = '/home/ellian/Documents/lifecon/orgDocuments/arqu/exemplo'
# exploreFiles(varPath)


# tratamento do nome do arquivo
array = os.listdir(varPath)
subArray = array[-1].split('-')
pdf = {
    'bank': '',
    'contract': '',
    'description': '',
    'cost': '',
    'date': ''
}
if len(subArray) == 5:
    pdf = {
        'bank': subArray[0],
        'contract': subArray[1],
        'description': subArray[2],
        'cost': subArray[3],
        'date': subArray[4]
    }
else:
    pdf = {
        'bank': subArray[0],
        'description': subArray[1],
        'cost': subArray[2],
        'date': subArray[3]
    }
