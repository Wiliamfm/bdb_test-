export interface Person {
    id: string,
    full_name: string,
    birth_date: string,
    father: {
        id: string,
        full_name: string
    },
    mother: {
        id: string,
        full_name: string
    }
}