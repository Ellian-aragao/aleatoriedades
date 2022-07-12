#!/usr/bin/python3

import docker

client = docker.from_env()

def format_container_name(container) -> str:
  return f'{container.name}:{container.short_id}'

def stop_all_containers(listContainers=client.containers.list()):
  for container in listContainers:
    print(f'Finalizando container {format_container_name(container)}')
    container.kill()
  return listContainers

def delete_all_containers(listContainers=client.containers.list(all=True)):
  for container in listContainers:
    print(f'Deletando container {format_container_name(container)}')
    container.remove()
  return listContainers



if __name__ == '__main__':
  listContainers = client.containers.list()
  if listContainers.__len__() == 0:
    print('Não há containers para finalizar')
    exit(0)
  stop_all_containers(listContainers)
  delete_all_containers(listContainers)