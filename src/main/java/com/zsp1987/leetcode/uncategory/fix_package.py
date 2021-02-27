from os import listdir

for f in listdir('./src/main/java/com/zsp1987/leetcode/uncategory'):
    filepath = './src/main/java/com/zsp1987/leetcode/uncategory/'+f
    with open(filepath) as f:
        lines = f.readlines()

    if lines[0] == "package com.zsp1987.leetcode;\n":
        print(lines[0])
        lines[0] = "package com.zsp1987.leetcode.uncategory;\n"
        with open(filepath, 'w') as of:
            of.writelines(lines)
