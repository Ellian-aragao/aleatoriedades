#!/bin/bash
<<.deb
    nesta parte encontram-se alguns programas que não haviam pacotes snaps 
    e então foram baixados pelos repositórios padrões do ubuntu
.deb
apt-get install gcc -y                  # compilador C
apt-get install virtualbox -y           # maquina virtual
apt-get install gnome-tweak-tool -y     # configurar aparencia do gnome
apt-get install vim -y                  # editor de texto via terminal
apt-get install git -y                  # gerenciador de versionamento
apt-get install qbittorrent -y          # donwload de torrent
apt-get install wireshark -y            # analisador de pacotes da rede
apt-get install calibre -y              # editor e leitor de ebooks
apt-get install python3-pip		        # gerenciador de pacotes python
apt-get install default-jdk -y          # pacote java atual


<<snaps
    usando a facilidade de gerenciar pacotes snaps visto a constante de atualizações
    e independência do sistema tornando aplicável a qualquer distro
snaps
snap install code --classic             # editor de codigos vscode
snap install android-studio --classic   # IDE android
snap install arduino                    # IDE arduino
snap install okular                     # leitor de PDF
snap install vlc                        # reprodutor de video e musica
snap install gimp                       # composição de fotos
snap install darktable                  # editor de fotos
snap install inkscape                   # editor vetorial
snap install discord        			# servidor de voz
snap install freac --beta		        # conversor de codec música
snap install audacity                   # edição de audio
snap install xmind                      # mapa mental
snap install kdenlive                   # editor de videos
snap install obs-studio                 # gravador de tela


<<timeShift
    programa para recuperação de imagem do sistema, cria snapshots do sistema para recuperação do sistema por completo
timeShift
add-apt-repository -y ppa:teejee2008/timeshift
apt-get update
apt-get install timeshift


<<removendoPacotes
    remove os pacotes básicos do ubuntu para utilização unica dos pacotes baixados 
    dos quais me são mais agradáveis a usabilidade deles tornando futeis os outros
removendoPacotes
apt-get remove evince -y                # remove leitor de PDF antigo
apt-get remove aisleriot -y             # paciência
apt-get remove gnome-mahjongg -y        # jogo
apt-get remove gnome-mines -y           # jogo
apt-get remove gnome-sudoku -y          # jogo
apt-get remove gnome-todo -y            # lista todo
apt-get remove totem -y                 # reprodutor de videos
apt-get remove transmission-gtk -y      # torrent nativo ubuntu


<<atualizando
    atualizando o sistema por completo e removendo dependências do sistema
atualizando
apt-get update && apt-get upgrade -y
apt autoremove -y && apt autoclean -y


<<extensãoGnome
    para o gnome, existe uma extensão que poupa alguns pixels de tela o que pode não fazer
    diferença, entretanto conseguir ver mais o conteúdo que se deseja sempre é algo agradável
    portanto, segue o nome e link da extensão

    No Title Bar
    https://extensions.gnome.org/extension/1267/no-title-bar/
extensãoGnome

<<appImage
    programas portaveis para qualquer distros
appImage
# gravador de pendrive bootável --> BalenaEtcher
wget https://github.com/balena-io/etcher/releases/download/v1.5.79/balena-etcher-electron-1.5.79-linux-x64.zip

# visual studio portable
wget https://github.com/zilti/code-oss.AppImage/releases/download/continuous/Code_OSS-x86_64.AppImage
