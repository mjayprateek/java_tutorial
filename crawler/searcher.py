from mysql.connector import *
from my_wordutil import *
from db_config import *
import sys

class searcher:
	def __init__(self, dbname):
		self.con = connect(**Config.localhost())
		self.cur = self.con.cursor()

	def __del__(self):
		self.con.close()

	def getmatchrows(self, q):
		qwords = WordUtil.separatewords(q)
		print("separated words " + str(qwords))

		result_set = set()
		
		for (i, word) in enumerate(qwords):
			print("%s:%s", i,word)
			
			if(word in WordUtil.ignorewords):
				continue
				
			urls = set(self.find_urls_matching(word))

			#print("urls: " + str(urls))
			
			if(i==1):
				result_set = urls
			else:
				result_set = urls.intersection(result_set)

			#print("\n\n\n\nresult_set: " + str(result_set))
			#print("\n\nlength: " + str(len(result_set)))

		return result_set


	def find_urls_matching(self, word):
		search_query = """ select distinct u.url from urls u join word_location wl on u.id = wl.url
				where wl.word in (select id from words 
				where word in ('%s')) """ % (word)
			
		print("search query : " + search_query)

		self.cur.execute(search_query)
		res = self.cur.fetchall()

		if(res!=None):
			print("rows: " + str(len(res))) 
			return [row for row in res]

		return []


def search():
	my_searcher = searcher('python')
	my_searcher.getmatchrows('to function in python')


if __name__ == "__main__":
	print ('running in command line. Reloading modules')
	search()
else:
	print ('running from another module: ' + __name__)


