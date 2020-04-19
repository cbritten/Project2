export class Categories{

    rev_id : number; 
    cleanliness: number; 
    qlife : number; 
    safety: number; 
    ammenities: number; 
    essentails: number; 

    constructor(rev_id: number, cleanliness: number, qlife: number, safety: number, ammenities: number, essentials: number){
        this.rev_id = rev_id; 
        this.cleanliness = cleanliness; 
        this.qlife = qlife; 
        this.safety = safety; 
        this.ammenities = ammenities; 
        this.essentails = essentials; 
    }
}