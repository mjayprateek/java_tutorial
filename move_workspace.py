import os
import sys


def move(new_code_dir, eclipse_workspace_path):
	eclipse_project_dir = eclipse_workspace_path + "/.metadata/.plugins/org.eclipse.core.resources/.projects/"
	
	print "looking for eclipse project folders in: " + eclipse_project_dir + "\n"

	print type(os.walk(eclipse_project_dir))	
	

	i = 0
	for root, dirnames, files in os.walk(eclipse_project_dir):
		if(i==1):
			break
		i = i + 1
		print root
		print dirnames

		for project_dir in dirnames:

			try:
				print "opening .location file for " + eclipse_project_dir + project_dir + "\n"
				location_file = open(eclipse_project_dir + project_dir + "/.location", "rb+")
				print location_file.read()
			except:
				print("inside exception")
				continue

			else:
				location  = location_file.read()
				
				if(len(location)==0):
					continue

				print "entire file's content in utf-8: " + location.decode("utf8") + "\n"

				print "entire file's content in raw bytes: " + location + "\n"

				print "setting file seek back to 0"
				location_file.seek(0)

				URI_position = location.find("URI//")
				print "URI// tag found at " + str(URI_position)

				location_file.seek(URI_position)
				print location_file.read()



move(sys.argv[1], sys.argv[2])

