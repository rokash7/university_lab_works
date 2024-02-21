# Padalinkite intervalą nuo -1.3 iki 2.5 tolygiai į 64 dalis.

starting_num = -1.3
ending_num = 2.5
parts = 64

parts_list = []
interval_size = ending_num - starting_num
step_size = interval_size / parts

for _ in range(parts):
    part = [starting_num, starting_num + step_size]
    starting_num += step_size
    parts_list.append(part)

print(parts_list)