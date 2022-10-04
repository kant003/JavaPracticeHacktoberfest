import glob

files = glob.glob('./*.md')
print(files)
for fi in files:
	f=open(fi,'r', encoding='utf-8')
	text = f.readlines()
	f.close()
	
	str = ""
	
	for line in text:
		tmp = line
		tmp = tmp.replace('a','i')
		tmp = tmp.replace('e','i')
		tmp = tmp.replace('o','i')
		tmp = tmp.replace('u','i')
		tmp = tmp.replace('á','í')
		tmp = tmp.replace('é','í')
		tmp = tmp.replace('ó','í')
		tmp = tmp.replace('ú','í')
		str += tmp

	print(str)
	
	f=open(fi,'w', encoding='utf-8')
	f.write(str)
	f.close()