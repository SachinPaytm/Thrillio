package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.constants.BookGenre;
import com.semanticsquare.thrillio.partner.Shareable;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Book extends Bookmark implements Shareable {
    private int publicationYear;
    private double amazonRating;
    private String publisher;
    private BookGenre genre;
    private String[] authors;

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publicationYear=" + publicationYear +
                ", amazonRating=" + amazonRating +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", authors=" + Arrays.toString(authors) +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
        if(genre==BookGenre.PHILOSOPHY || genre==BookGenre.SELF_HELP) return false;
        return true;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
            builder.append("<type>").append("Book").append("</type>");
            builder.append("<title>").append(getTitle()).append("</title>");
            builder.append("<authors>").append(StringUtils.join(authors,",")).append("</authors>");
            builder.append("<publisher>").append(publisher).append("</publisher>");
            builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
            builder.append("<genre>").append(genre).append("</genre>");
            builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
        builder.append("</item>");
        return builder.toString();
    }
}