import unittest
import requests

URL_DETALHES ='http://localhost:8003/api/detalhes'
URL_FEEDS = 'http://localhost:8002/api/personagens'

class APITest(unittest.TestCase):
    def test_deve_retornar_sucesso_se_status_ok_e_lista_feeds_nao_vazia(self):
        response = requests.get(URL_FEEDS)

        self.assertEqual(response.status_code, 200, "A resposta não é 200")
        self.assertTrue(response.json().get('content'), "O atributo 'content' está vazio")

    def test_deve_retornar_sucesso_se_status_ok_e_detalhe_existente(self):
        response = requests.get(URL_DETALHES + '/1')
        self.assertEqual(response.status_code, 200, "A resposta não é 200")

    def test_deve_retornar_sucesso_se_status_not_found(self):
            response = requests.get(URL_DETALHES + '/99')
            self.assertEqual(response.status_code, 404, "A resposta não é 200")

if __name__ == '__main__':
    unittest.main()