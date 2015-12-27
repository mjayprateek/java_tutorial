#def firstFunction(obj):
#	print(obj+1);

##firstFunction(10);

##print(firstFunction(21));


#def right_justify(str):
#	print(' '*40 + str)

##right_justify('prateek')

#def call(f):
#	f('prateek');

##call(right_justify);

#def pretty_printing():
#	edge_part = '+ - - - -'
#	edge = edge_part*2+'+'

#	row_part = '/' +' '*8
#	row = (row_part*2+'/');

#	print(edge)

#	print(row)
#	print(row)
#	print(row)

#	print(edge)

#	print(row)
#	print(row)
#	print(row)

#	print(edge);

##pretty_printing();

#from sys import *
#def fsum(input):
#	print input
#	try:
#		s = sum(int(i) for i in input[1:])
#		print s
#	except ValueError:
#		print "exception: can not convert to integer"

##fsum(argv)

# import urllib.request
# url = urllib.request.urlopen("http://www.bangaloremirror.com/")
# content = url.read();
# print(content)

import bs4
import urllib2

# def search(doc, word):
# 	collections = []
# 	if(doc.find(word)!=-1)
#  		return collections.add(doc)


# def retrieveContent(webpage):
# 	for link in webpage.find_all('a'):
#     	print type(link)
#         print('getting content from ' + link.get('href'))
#         relevant_pages = search()


def fib(n):
	initial = 1
	last_fib = initial
	fib = initial
	old_dib = initial
	print last_fib
	print fib

	for i in range(n-2):
		temp = fib
		fib = fib + last_fib
		last_fib = temp
		print fib


def rfib(n):
	if(n==0):
		return 1

	if(n==1):
		return 1

	return rfib(n-2) + rfib(n-1)


def print_fibs(n):
	for i in range(n):
		print rfib(i)












