import urllib.request, urllib.error, json, csv, os, sys, time

sys.stdout.reconfigure(encoding='utf-8')

print("=" * 80)
print("      TRƯỜNG ĐẠI HỌC VĂN LANG - KHOA CÔNG NGHỆ THÔNG TIN")
print("          KIỂM THỬ TỰ ĐỘNG - BÀI THỰC HÀNH 09 (API TESTING)")
print("  Sinh viên: Nguyễn Minh Phú - MSSV: 2374802013447 - Lớp: 232_71ITSE41603_0102")
print("=" * 80)
print()

BASE_URL = "https://jsonplaceholder.typicode.com"
passed_count = 0
total_count = 0

def log_test(test_name, passed, detail=""):
    global passed_count, total_count
    total_count += 1
    if passed:
        passed_count += 1
        print(f" [PASS] {test_name} {('- ' + detail) if detail else ''}", flush=True)
    else:
        print(f" [FAIL] {test_name} {('- ' + detail) if detail else ''}", flush=True)

def http_request(url, method="GET", data=None, headers=None, retries=2):
    if headers is None:
        headers = {}
    headers.setdefault("User-Agent", "PostmanRuntime/7.39.0")
    if data:
        encoded_data = json.dumps(data).encode("utf-8")
        headers.setdefault("Content-Type", "application/json; charset=UTF-8")
    else:
        encoded_data = None
    
    for attempt in range(retries):
        req = urllib.request.Request(url, data=encoded_data, headers=headers, method=method)
        start_time = time.time()
        try:
            with urllib.request.urlopen(req, timeout=6) as resp:
                elapsed_ms = (time.time() - start_time) * 1000
                res_body = resp.read().decode("utf-8")
                try:
                    res_json = json.loads(res_body)
                except:
                    res_json = res_body
                time.sleep(0.1)
                return resp.status, resp.headers, res_json, elapsed_ms
        except urllib.error.HTTPError as e:
            elapsed_ms = (time.time() - start_time) * 1000
            return e.code, e.headers, None, elapsed_ms
        except Exception as e:
            if attempt < retries - 1:
                time.sleep(0.3)
                continue
            return 0, {}, None, 9999

print("=== PHẦN 1: CÁC PHƯƠNG THỨC HTTP CƠ BẢN (CRUD OPERATIONS) ===")
# 1. GET Users
status, headers, body, t = http_request(f"{BASE_URL}/users")
log_test("GET /users - Status Code is 200", status == 200, f"{status} OK ({t:.0f}ms)")
log_test("GET /users - Response is array > 0", isinstance(body, list) and len(body) > 0, f"{len(body)} users returned")

# 2. POST User
user_data = {
    "id": 11,
    "name": "PHAN PHƯỚC",
    "username": "PLT",
    "email": "plt@gmail.com",
    "address": {
        "street": "Duong 14",
        "suite": "Apt. 666",
        "city": "Thuan An",
        "zipcode": "92998-3874",
        "geo": {"lat": "-37.3159", "lng": "81.1496"}
    }
}
status, headers, body, t = http_request(f"{BASE_URL}/users", method="POST", data=user_data)
log_test("POST /users - Status Code is 201 Created", status == 201, f"{status} Created")
log_test("POST /users - Body check: name is PHAN PHƯỚC", isinstance(body, dict) and body.get("name") == "PHAN PHƯỚC")

# 3. POST Post
post_data = {"userId": 11, "id": 101, "title": "PLT SOLUTIONS", "body": "Xin chào các bạn"}
status, headers, body, t = http_request(f"{BASE_URL}/posts", method="POST", data=post_data)
log_test("POST /posts - Status Code is 201 Created", status == 201, f"{status} Created")
log_test("POST /posts - Body check: title is PLT SOLUTIONS", isinstance(body, dict) and body.get("title") == "PLT SOLUTIONS")

# 4. PUT Post/5
put_data = {"userId": 1, "id": 5, "title": "PLT PHAN PHƯỚC", "body": "KIỂM THỬ TỰ ĐỘNG - XIN CHÀO CÁC BẠN"}
status, headers, body, t = http_request(f"{BASE_URL}/posts/5", method="PUT", data=put_data)
log_test("PUT /posts/5 - Status Code is 200 OK", status == 200, f"{status} OK")
log_test("PUT /posts/5 - Body check: title updated", isinstance(body, dict) and body.get("title") == "PLT PHAN PHƯỚC")

# 5. DELETE Post/5
status, headers, body, t = http_request(f"{BASE_URL}/posts/5", method="DELETE")
log_test("DELETE /posts/5 - Status Code is 200 OK", status == 200, f"{status} OK")

print()
print("=== PHẦN 2: TEST SCRIPTS & ASSERTIONS ===")
# 6. GET /users assertions
status, headers, body, t = http_request(f"{BASE_URL}/users")
log_test("Assert Status Code in [200, 201]", status in [200, 201])
log_test("Assert ID2 is Ervin Howell", isinstance(body, list) and body[1]["name"] == "Ervin Howell")
log_test("Assert First user is Leanne Graham", isinstance(body, list) and body[0]["name"] == "Leanne Graham")
log_test("Assert First user street is Kulas Light", isinstance(body, list) and body[0]["address"]["street"] == "Kulas Light")
log_test("Assert First user geo.lng is 81.1496", isinstance(body, list) and body[0]["address"]["geo"]["lng"] == "81.1496")
log_test("Assert Content-Type contains application/json", "application/json" in headers.get("Content-Type", ""))
log_test("Assert Response time < 4000ms (Network Latency Check)", t < 4000, f"{t:.0f}ms")

# 7. GET /posts/5 Data Types
status, headers, body, t = http_request(f"{BASE_URL}/posts/5")
log_test("Data Types: response is object", isinstance(body, dict))
log_test("Data Types: userId is number", isinstance(body.get("userId"), (int, float)))
log_test("Data Types: id is number", isinstance(body.get("id"), (int, float)))
log_test("Data Types: title is string", isinstance(body.get("title"), str))
log_test("Data Types: body is string", isinstance(body.get("body"), str))

# 8. ReqRes Single User
status, headers, body, t = http_request("https://reqres.in/api/users/2")
log_test("ReqRes /api/users/2 - Status Code is 200", status == 200)
log_test("ReqRes - User id is 2", isinstance(body, dict) and body.get("data", {}).get("id") == 2)
log_test("ReqRes - User email is janet.weaver@reqres.in", isinstance(body, dict) and body.get("data", {}).get("email") == "janet.weaver@reqres.in")

print()
print("=== PHẦN 3: DATA-DRIVEN TESTING VỚI FILE JSON & CSV ===")
# 9. JSON Data-Driven
json_path = os.path.join(os.path.dirname(__file__), "data_globals.json")
if not os.path.exists(json_path):
    json_path = r"D:\ktdt\Bài thực hành 9-20261113\data_globals.json"

with open(json_path, "r", encoding="utf-8") as f:
    json_records = json.load(f)

print(f"-> Thuc thi Collection Runner voi {len(json_records)} ban ghi JSON:")
for idx, rec in enumerate(json_records, start=1):
    payload = {"userId": rec["UID"], "id": rec["ID"], "title": rec["Title"], "body": rec["Body"]}
    s, h, b, el = http_request(f"{BASE_URL}/posts", method="POST", data=payload)
    match_title = isinstance(b, dict) and b.get("title") == rec["Title"]
    match_body = isinstance(b, dict) and b.get("body") == rec["Body"]
    log_test(f"Iteration {idx} (JSON) - UID={rec['UID']}, Title='{rec['Title']}'", s == 201 and match_title and match_body)

# 10. CSV Data-Driven
csv_path = os.path.join(os.path.dirname(__file__), "data_globals.csv")
if not os.path.exists(csv_path):
    csv_path = r"D:\ktdt\Bài thực hành 9-20261113\data_globals.csv"

with open(csv_path, "r", encoding="utf-8") as f:
    reader = csv.DictReader(f)
    csv_records = list(reader)

print(f"-> Thuc thi Collection Runner voi {len(csv_records)} ban ghi CSV:")
for idx, rec in enumerate(csv_records, start=1):
    payload = {"userId": int(rec["UID"]), "id": int(rec["ID"]), "title": rec["Title"], "body": rec["Body"]}
    s, h, b, el = http_request(f"{BASE_URL}/posts", method="POST", data=payload)
    match_title = isinstance(b, dict) and b.get("title") == rec["Title"]
    match_body = isinstance(b, dict) and b.get("body") == rec["Body"]
    log_test(f"Iteration {idx} (CSV) - UID={rec['UID']}, Title='{rec['Title']}'", s == 201 and match_title and match_body)

# 11. Variable with GET CSV (Variable_Id.csv)
id_csv_path = os.path.join(os.path.dirname(__file__), "Variable_Id.csv")
if not os.path.exists(id_csv_path):
    id_csv_path = r"D:\ktdt\Bài thực hành 9-20261113\Variable_Id.csv"

with open(id_csv_path, "r", encoding="utf-8") as f:
    reader = csv.DictReader(f)
    id_records = list(reader)

print(f"-> Thuc thi Variable with GET CSV voi {len(id_records)} ban ghi:")
for idx, rec in enumerate(id_records, start=1):
    pid = rec["Id"]
    s, h, b, el = http_request(f"{BASE_URL}/posts/{pid}", method="GET")
    match_id = isinstance(b, dict) and b.get("id") == int(pid)
    log_test(f"Iteration {idx} (GET /posts/{pid}) - id matches", s == 200 and match_id)

print()
print("=" * 80)
print(f"   TỔNG KẾT KẾT QUẢ: {passed_count}/{total_count} TESTS PASSED (TỶ LỆ: {(passed_count/total_count)*100:.1f}%)")
print("=" * 80)
