from Destino import Destino

class DestinoRepository:
        lista_destino: Destino = []

        def adicionar_destino(self, destino: Destino) -> None:
            self.lista_destino.append(destino)
       
        def checa_se_destino_existe(self, destino:Destino):
            for item in self.lista_destino:
                if (destino.destino.upper() == item.destino.upper()):
                    return True

            return False
            
        def obter_destino_pelo_ddd(self, destino:Destino):
            for item in self.lista_destino:
                if (destino.ddd == item.ddd):
                    print(item.destino)
                    return True
            print("ddd não cadatrado")
            return False
