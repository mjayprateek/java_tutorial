import os
import difflib
import sys

su1 = os.walk('/Users/prateekkhatri/novopay/m-kirana-suite/server/source/mpay-platform/services/service-user1.1/service/src/main/java/com/khoslalabs/service')

def print_diff():
	for root, dirs, files in su1:
	     for f in files:
		    path_in_su1 = os.path.join(root, f)
		    print path_in_su1
		    
		    path_in_su0 = path_in_su1.replace('1.1', '')
		    print path_in_su0

		    if not(os.path.exists(path_in_su0)):
		    	print "file %s does not exists in service-user. Skipping ..." % f
		    	continue;

		    su1_lines = open(path_in_su1, 'U').readlines()
		    su0_lines = open(path_in_su0, 'U').readlines()

		    #print 'comparing %s and %s '% path_in_su1, path_in_su0

		    diff = difflib.context_diff(su1_lines, su0_lines)
		    sys.stdout.writelines(diff)


print_diff()


