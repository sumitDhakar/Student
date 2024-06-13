
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




public class SecondLargestNumber {
    public static void main(String[] args) {
        int[] a = {68, 68, 8, 49, 39, 53, 68};
        int b = a.length;
        int first, second;

        
        if (size < 2) {
            
            return;
        }

        first = second = Integer.MIN_VALUE;

        for (int i = 0; i < b; i++) {
            if (a[i] > first) {
                second = first;
                first = a[i];
            } else if (a[i] > second && a[i] != first) {
                second = a[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println(" second largest element");
        } else {
            System.out.println("The second largest element is " + second);
        }
    }
}

