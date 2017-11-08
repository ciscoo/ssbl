package io.pivotal.workshop.snippetproducer.domain

class Snippet {
    private String id
    private String title
    private String code
    private Date created
    private Date modified

    Snippet(String title, String code) {
        this.id = "${UUID.randomUUID()}"
        this.title = title
        this.code = code
        this.created = new Date()
        this.modified = new Date()
    }
}
