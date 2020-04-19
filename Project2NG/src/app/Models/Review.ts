export class Review{

    rev_id : number; 
    user_id : number; 
    neighb_id : number; 
    dateOf: Date; 
    tUp : number; 
    tDown : number; 
    info : string; 

    constructor(rev_id: number, user_id: number, neighb_id: number, tUp: number, tDown: number, info: string){

        this.rev_id = rev_id; 
        this.user_id = user_id; 
        this.neighb_id = neighb_id; 
        this.tUp = tUp; 
        this.tDown = tDown; 
        this.info = info; 
    }
}