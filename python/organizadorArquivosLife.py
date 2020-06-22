import os


class FilesPdf:
    def __init__(self, fullPath):
        self.fullPath = fullPath

    def pathFileSeparate(self):
        print(self.fullPath.rindex('/'))
        arrayFullPath = self.fullPath.rsplit() rsplit(56)
        print(arrayFullPath)
        self.nameFile = arrayFullPath[-1]
        arrayFullPath.pop(-1)
        self.pathDir = '/'.join(arrayFullPath)


    def getFullPath(self):
        return self.fullPath


def findFiles(absolute_path):
    arrayDirOrFiles = os.listdir(absolute_path)
    files = []
    for oneFileOrDir in arrayDirOrFiles:
        fullPath = '{}/{}'.format(absolute_path, oneFileOrDir)
        if os.path.isdir(fullPath):
            array = findFiles(fullPath)
            for item in array:
                files.append(item)
        else:
            files.append(fullPath)
    return files


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


path = '/home/ellian/Documents/lifecon/orgDocuments/arqu/exemplo'
array = findFiles(path)
file = FilesPdf(array[-1])
file.pathFileSeparate()
