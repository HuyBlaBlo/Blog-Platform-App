==========AUTH==========
POST    /api/v1/auth/login      Authenticate user and receive JWT token

==========POST==========
GET     /api/v1/posts             Get all published post
POST    /api/v1/posts             Create a new post
GET     /api/v1/posts/{id}        Get specific post
PUT     /api/v1/posts/{id}        Update existing post
DELETE  /api/v1/posts/{id}        Delete post
GET     /api/v1/posts/drafts      Get drafts post for authenticate users

==========CATEGORY==========
GET     /api/v1/categories        Get all category
POST    /api/v1/categories        Create a new category
DELETE  /api/v1/categories/{id}   Delete category

==========TAG===========
GET     /api/v1/tags              Get all tag
POST    /api/v1/tags              Create a new tag
DELETE  /api/v1/tags/{id}         Delete tag
