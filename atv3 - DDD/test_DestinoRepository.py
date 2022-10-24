from Destino import Destino
from DestinoRepository import DestinoRepository

destino_repository = DestinoRepository()
destino_repository.adicionar_destino(Destino(71, "Salvador"))
destino_repository.adicionar_destino(Destino(61, "Brasilia"))
destino_repository.adicionar_destino(Destino(11, "São Paulo"))

def test_exibir_destinos():
   result = len(destino_repository.lista_destino)

   assert result == 3

def test_adicionar_destino():
   destino_repository.adicionar_destino(Destino(21, "Rio de Janeiro"))
   destino_repository.adicionar_destino(Destino(32, "Juiz de Fora"))

   result = len(destino_repository.lista_destino)
   assert result == 5

def test_checa_se_destino_existe():
   
   result = destino_repository.checa_se_destino_existe(Destino(0,"feira de santana"))
   result2 = destino_repository.checa_se_destino_existe(Destino(0,"Salvador"))

   assert result == False
   assert result2 == True

def test_obter_destino_pelo_ddd():

   result = destino_repository.obter_destino_pelo_ddd(Destino(75,""))
   result2 = destino_repository.obter_destino_pelo_ddd(Destino(71,""))

   assert result == False
   assert result2 == True