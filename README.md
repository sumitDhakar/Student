
1 api student create
http://localhost:9101/api/auth/STUDENT





{
    "id": 2,
    "studentName": sumit,
    "userRoles": [
        {
            "id": 2,
            "roles": {
                "id": 1,
                "title": null
            }
        }
    ],
    "email": "1213sumitdhakar@gamil.com",
    "password": "$2a$10$JuzqCqu3RLyxmVRlQUcNlevHHazLDSyCR1d2nUXw5kV/U4hgiS.By",
    "createdAt": "2024-06-13",
    "deleted": false
}


2. api student login
http://localhost:9101/api/auth/signin

{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjEzc3VtaXRkaGFrYXJAZ2FtaWwuY29tIiwiaXNzIjoic2ltaXQgZGhha2FyIiwiZXhwIjoxNzE4MzAxODg3LCJpYXQiOjE3MTgyNjU4ODd9.Qwiy9uOzYnO_YGJeaOYcU_v9ujvB-B5LGeLcqgoFLLs",
    "description": null
}
