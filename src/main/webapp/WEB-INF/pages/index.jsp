<html>
<style>
    body{
        padding: 200px;
        padding-left: 500px;
    }
    input{
        padding: 5px;
    }
</style>
<body>
<h2>Upload input file</h2>
<form method="POST" action="upload" enctype="multipart/form-data">
    Choose file : <input type="file" name="file"><br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>
