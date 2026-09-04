

class User{
    private String username;
    private String displayName;
    Post[] posts;
    String profilePic;  
    User(String username, String displayName, String profilePic){
        this.username=username;
        this.displayName=displayName;
        this.profilePic=profilePic;
    }
    User(String username){
        this(username, "Unknown", "Unknown");
    }
    User(){
        this("Unknown", "Unknown", "Unknown");
    }
    void newTextMessage(String message) {
        TextMessage textMessage = new TextMessage(message);
    }
    void newPictureMessage(String imageUrl) {
        PictureMessage pictureMessage = new PictureMessage(imageUrl);
    }
    void newVideoMessage(String youtubeLink) {
        VideoMessage videoMessage = new VideoMessage(youtubeLink);
    }
    int getPostCount() {
        return posts.length;
    }
    Post getPost(int index) {
        return posts[index];
    }
    void newComment(int postIndex, String comment, User author) {
        posts[postIndex].newComment(comment, author);
    }
    void newLike(int postIndex) {
        posts[postIndex].newLike();
    }

}

class TextMessage extends Post{
    String message;

    public TextMessage(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

class PictureMessage extends Post{
    String imageUrl;
    PictureMessage(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

class VideoMessage extends Post{
    String YoutubeLink;
    VideoMessage(String YoutubeLink){
        this.YoutubeLink = YoutubeLink;
    }
    public String getYoutubeLink() {
        return YoutubeLink;
    }
    public void setYoutubeLink(String YoutubeLink) {
        this.YoutubeLink = YoutubeLink;
    }

}

class Post{
    int likeCount;
    Comment[] comments;
    Post(){
        
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }
    void newComment(String comment, User author) {
        Comment newComment = new Comment(comment, author);
    }
    void newLike() {
        setLikeCount(getLikeCount() + 1);
    }

}

class Comment{
    String comment;
    User author;
    Comment(String comment, User author){
        this.comment=comment;
        this.author=author;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

class Figure {
    private double dim1;
    private double dim2;
    Figure(double dim1, double dim2){
        this.dim1=dim1;
        this.dim2=dim2;
    }
    Figure (double dim1){
        this(dim1, dim1);
    }

    Figure ()
    {
        this(11);
    }
    public double area()
    {
        return(this.dim1 * this.dim2)/2.0;
    }
    public double getDim1()
    {return dim1;}
    public double getDim2()
    {return dim2;}
    public void setDim1(double x)
    {this.dim1=x;}
    public void setDim2(double x)
    {this.dim2=x;}
}

class Rectangle extends Figure {
    Rectangle(double a, double b){
    super(a,b);}

    public double area()
    {
        return getDim1()*getDim2();
    }
}

class Triangle extends Figure {
    Triangle(double a, double b){
        super(a,b);}

    public double area()
    {
        return (getDim1()*getDim2())/2.0;
    }
}

public class homework2 {
    public static void main(String[] args) {
        Figure f1 = new Figure(10, 20);
        System.out.println("Area " + f1.area());

        Rectangle r1 = new Rectangle(10, 20);
        System.out.println("Area " + r1.area());

        Triangle t1 = new Triangle(10, 20);
        System.out.println("Area " + t1.area());
    }

}