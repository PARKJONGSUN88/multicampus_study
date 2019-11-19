# for c in "string":
#     print(c)


# scores={
#     "a": {
#         "수학":80,
#         "국어":90,
#         "음악":100
#     },
#     "b": {
#         "수학":80,
#         "국어":70,
#         "음악":80
#     }
# }


# a_avg = sum(scores["a"].value()) / len(scores["a"])
# b_avg = sum(scores["b"].value()) / len(scores["b"])

# avg = (a_avg + b_avg) / 2
# print(avg)


city = {
    "서울" : [-6, -10, 5],
    "대전" : [-3, -5, 2],
    "광주" : [0, -2, 10],
    "부산" : [2, -2, 9]
}

# for name, temp in city.items():
#     avg_temp = sum(temp) /len(temp)
#     print(f'{name} : 평균 기온은 {avg_temp}입니다.')

print("있어요") if 2 in city["서울"] else print ("없어요")



