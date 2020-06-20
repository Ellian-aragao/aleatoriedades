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
            'date': processingDate(arrayAttributes[4])
        }
    else:
        pdf = {
            'bank': arrayAttributes[0],
            'description': arrayAttributes[1],
            'cost': arrayAttributes[2],
            'date': processingDate(arrayAttributes[3])
        }
    return pdf

def processingDate(dateWithExtension):
    arrayDate = dateWithExtension.split('.')
    date = {
        'day': arrayDate[0],
        'month': arrayDate[1],
        'year': arrayDate[2]
    }
    return date

varPath = '/home/ellian/Documents/lifecon/orgDocuments/arqu/exemplo'

array = os.listdir(varPath)
pdf = fileAttributesExtractor(array[-1])
print(pdf['date'])
