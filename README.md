# DZ2

So the this I dont understand is why the browser is always blocking authentication. Nevermind I wasted 3 hours searching for that. Please use 

# Accessing the hello-all endpoint (no authentication required)
curl http://localhost:8080/hello-all

# Accessing the hello-user endpoint (authentication required)
curl -u user:password http://localhost:8080/hello-user

# Accessing the hello-admin endpoint (authentication required)
curl -u admin:password http://localhost:8080/hello-admin

