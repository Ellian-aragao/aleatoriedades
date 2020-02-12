#!/bin/bash

apt-get install vim -y		    # editor de texto via terminal
apt-get install qbittorrent     # donwload de torrent
#apt-get install wireshark      # analisador de pacotes da rede
#apt-get install calibre        # editor e leitor de ebooks


snap install code --classic	    # editor de codigos vscode
snap install gimp		        # composição de fotos
snap install vlc		        # reprodutor de video e musica
snap install okular             # leitor de PDF
# snap install audacity		    # edição de audio
# snap install darktable	    # editor de fotos
# snap install xmind		    # mapa mental
# snap install inkscape		    # editor vetorial
# snap install kdenlive		    # editor de videos
# snap install obs-studio       # gravador de tela


echo "baixando e atualizando os pacotes"
apt-get update && apt-get upgrade -y
echo "limpando cache"
apt autoremove && apt autoclean -y
echo "terminada a atualização"