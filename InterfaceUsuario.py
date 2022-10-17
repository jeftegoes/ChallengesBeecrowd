from Destino import Destino
from DestinoRepository import DestinoRepository

class InterfaceUsuario:

    def __init__(self, destino_repository: DestinoRepository) -> None:
        self.destino_repository = destino_repository

    def solicitar_input_usuario(self):
        return int(input("digite o ddd para descobrir a localidade:"))

    def exibir_destinos(self):
        return self.destino_repository.lista_destino

    def saida_usuario(self):
        ddd = self.solicitar_input_usuario()
        return self.destino_repository.obter_destino_pelo_ddd(ddd)
