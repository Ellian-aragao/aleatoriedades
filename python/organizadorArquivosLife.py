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

def fileAttributesExtractor(fileName):
    arrayAttributes = fileName.split('-')
    pdf = {
        'bank': '',
        'contract': '',
        'description': '',
        'cost': '',
        'date': ''
    }
    if len(arrayAttributes) == 5:
        pdf = {
            'bank': arrayAttributes[0],
            'contract': arrayAttributes[1],
            'description': arrayAttributes[2],
            'cost': arrayAttributes[3],
            'date': arrayAttributes[4]
        }
    else:
        pdf = {
            'bank': arrayAttributes[0],
            'description': arrayAttributes[1],
            'cost': arrayAttributes[2],
            'date': arrayAttributes[3]
        }
    return pdf

varPath = '/home/ellian/Documents/lifecon/orgDocuments/arqu/exemplo'
# exploreFiles(varPath)

array = os.listdir(varPath)

print(fileAttributesExtractor(array[-1]))
