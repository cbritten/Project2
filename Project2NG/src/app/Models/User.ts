export class P2user {

    userId : number; 
    roleof : string; 
    username : string; 
    pword : string; 
    email : string; 
    fname : string; 
    lname: string; 
    neighborhood: string; 
    rating: number = 0; 
    allowemail: number; 

    constructor(userId: number, roleof: string, username : string, pword: string, email: string, fname: string, lname: string, neighborhood: string, rating: number, allowemail: number){

        this.userId = userId;
        this.roleof =roleof;  
        this.username = username; 
        this.pword = pword; 
        this.email = email; 
        this.fname = fname; 
        this.lname = lname; 
        this.neighborhood = neighborhood; 
        this.rating = rating; 
        this.allowemail = allowemail; 
    }
    
}