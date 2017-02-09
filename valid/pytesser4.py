import sys
from PIL import Image
from pytesser import pytesser
print sys.argv[1]
#E:\\zhuomian\\scripttest\\python\\pytesser\\
img = Image.open(sys.argv[1].replace("%20"," "))
img=img.resize((64,63),Image.ANTIALIAS)
imgry = img.convert('L')
dd=pytesser.image_to_string(imgry)
f=file(sys.argv[2].replace("%20"," "),'w+')
f.write(dd)
f.close()
#region = (5,10,34,30)


#32
#img=img.resize((48,48),Image.ANTIALIAS)
#region = (8,14,40,38)

#cropImg = img.crop(region)

#cropImg.save('E:\\zhuomian\\scripttest\\python\\pytesser\\Coder123.jpg')
